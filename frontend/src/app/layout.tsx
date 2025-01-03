import type { Metadata } from "next";
import { Oswald } from "next/font/google";
import "./globals.css";
import { cn } from "@/lib/utils";
import { ThemeProvider } from "@/components/theme-provider";

export const metadata: Metadata = {
  title: "B - A Rede Social do Momento",
  description: "Criada por Bernardino",
};

const oswald = Oswald({
  weight: ["200", "400", "700"],
  subsets: ["latin"],
  variable: "--font-oswald" // So we can use it on tailwind
});


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-BR">
      <body className={cn("min-h-screen bg-background font-oswald antialiased", oswald.className)}>
        <ThemeProvider // Black theme
          attribute="class"
          defaultTheme="dark"
          enableSystem
          disableTransitionOnChange
        >
          {children}
        </ThemeProvider>
      </body>
    </html>
  );
}
